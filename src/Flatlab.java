package flatlab;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.glfw.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.glfw.GLFW.*;

public class Flatlab {

    private long window;

    private GLFWErrorCallback errorCallback;
    private GLFWKeyCallback keyCallback;
    private GLFWMouseButtonCallback mouseButtonCallback;
    private GLFWCursorPosCallback cursorPosCallback;
    private GLFWScrollCallback scrollCallback;

    private Scene _scene;

    private int _width;
    private int _height;

    public Flatlab(Scene scene) {
        _scene = scene;
        _width = _scene.width();
        _height = _scene.height();
    }

    public void start() {
        try {
            init();
            loop();

            // Callbacks.glfwFreeCallbacks(window);
            glfwDestroyWindow(window);
        } finally {
            glfwTerminate();
        }
    }

    private void init() {
        if ( glfwInit() != GL_TRUE )
            throw new IllegalStateException("Unable to initialize GLFW");

        // setup window style
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);

        window = glfwCreateWindow(_width, _height, "flatlab", NULL, NULL);
        if(window == 0)
            throw new RuntimeException("Failed to create the GLFW window");

        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(
                         window,
                         (vidmode.width() - _width) / 2,
                         (vidmode.height() - _height) / 2
                         );

        glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));

        setupInput();

        // create and setup gl context
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glfwSwapInterval(1);

        // show window
        glfwShowWindow(window);

        // setup 2d rendering
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, _width, _height, 0, 1, -1); // (0, 0) = top left
        glMatrixMode(GL_MODELVIEW);

        // we want to be able to use transparent textures
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        glClearColor(0.247f, 0.247f, 0.247f, 1.0f); // zenburn-bg

        _scene.init();

        long memory_used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("memory used: " + memory_used / 1000000f + " mb");
    }

    private void setupInput() {
        glfwSetKeyCallback(window, keyCallback = GLFWKeyCallback.create((window, key, scancode, action, mods) -> {
                    if ( key == GLFW_KEY_Q && action == GLFW_RELEASE )
                        glfwSetWindowShouldClose(window, GL_TRUE);

                    _scene.key(key, action, mods);
                }));

        glfwSetMouseButtonCallback(window, mouseButtonCallback = GLFWMouseButtonCallback.create((window, button, action, mods) -> {
                    _scene.mouse_click(button, action, mods);
                }));

        glfwSetCursorPosCallback(window, cursorPosCallback = GLFWCursorPosCallback.create((window, xpos, ypos) -> {
                    _scene.mouse_move((float)xpos, (float)ypos);
                }));

        glfwSetScrollCallback(window, scrollCallback = GLFWScrollCallback.create((window, xoffset, yoffset) -> {
                    _scene.mouse_scroll((float)xoffset, (float)yoffset);
                }));
    }

    float t = 0; // total time spent
    float dt = 1 / 10.0f; // used to decide how much we update this frame
    float accumulator = 0.0f; // used in conjunction with dt
    float frame_time = 0; // time spent this frame

    long current_time = 0; // time of this frame
    long last_time = 0; // time of the last frame

    int logic_ticks = 0; // how many times we updated this frame

    int fps; // how many frame per second we run
    int fps_counter; // used to count up frames
    long last_fps_time; // last time we counted up frames

    public static long getTime() {
        return System.nanoTime() / 1000000;
    }

    private void loop() {
        current_time = last_time = last_fps_time = getTime();

        while ( glfwWindowShouldClose(window) == GL_FALSE ) {
            current_time = getTime();
            logic_ticks = 0;

            frame_time = current_time - last_time;

            if(frame_time > 0.25f)
                frame_time = 0.25f;

            accumulator += frame_time;

            last_time = current_time;

            while(accumulator >= dt) {
                logic_ticks++;

                _scene.update(dt);

                accumulator -= dt;
                t += dt;
            }

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            // print fps / update info every seconds
            if (getTime() - last_fps_time > 1000) {
                fps = fps_counter;
                fps_counter = 0;
                last_fps_time += 1000;
                System.out.println(fps + " | " + logic_ticks);
            }

            fps_counter++;
            _scene.draw();

            glfwPollEvents();
            glfwSwapBuffers(window);
        }
    }
}
