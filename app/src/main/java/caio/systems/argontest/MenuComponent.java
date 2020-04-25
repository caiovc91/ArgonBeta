package caio.systems.argontest;

public class MenuComponent {

    private int menuIcon;
    private String menuItem;

    public MenuComponent(int menuIcon, String menuItem) {
        this.menuIcon = menuIcon;
        this.menuItem = menuItem;
    }

    public int getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(int menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String toString() {
        return this.menuItem;
    }
}
