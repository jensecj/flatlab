public abstract class Scene {
    public void key(int key, int action, int mods) {}
    public void mouse_click(int button, int action, int mods) {}
    public void mouse_move(float x, float y) {}
    public void mouse_scroll(float x, float y) {}

    public abstract void init();
    public abstract void update(float dt);
    public abstract void draw();

    private int _width;
    private int _height;
    public int width() { return _width; }
    public int height() { return _height; }

    public Scene(int width, int height) {
        _width = width;
        _height = height;
    }
}
