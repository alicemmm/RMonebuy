package mmm.asia.rmonebuy.ui.view.bottomtab;

/**
 * Created by asia on 02/12/2016.
 */

public class BottomNavigationItem {
    private String title;
    private int titleColor;
    private int imageResource;

    public BottomNavigationItem(String title, int titleColor, int imageResource) {
        this.title = title;
        this.titleColor = titleColor;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getImageResource() {
        return imageResource;
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
