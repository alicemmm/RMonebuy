package mmm.asia.rmonebuy.ui.view.bottomNavigation;

/**
 * Created by asia on 25/11/2016.
 */

public class BottomNavigationItem {
    private String title;
    private int color;
    private int imageResource;
    private int imageResourceActive = 0;

    public BottomNavigationItem(String title, int color, int imageResource) {
        this.title = title;
        this.color = color;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResourceActive() {
        return imageResourceActive;
    }

    public void setImageResourceActive(int imageResourceActive) {
        this.imageResourceActive = imageResourceActive;
    }

    public static class Builder {
        private String title;
        private int color;
        private int imageResource;

        public Builder() {

        }

        public Builder setImageResource(int imageResource) {
            this.imageResource = imageResource;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setColor(int color) {
            this.color = color;
            return this;
        }

        public BottomNavigationItem build() {
            return new BottomNavigationItem(title, color, imageResource);
        }
    }
}
