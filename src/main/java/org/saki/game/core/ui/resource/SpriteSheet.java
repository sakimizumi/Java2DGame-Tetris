package org.saki.game.core.ui.resource;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class SpriteSheet {
    private List<Sprite> sheet;
    SpriteSheet(){
        sheet = new ArrayList<>();
    }

    public void add(BufferedImage image){
        sheet.add(new Sprite(image));
    }

    public Sprite getSprite(int i) {
        return sheet.get(i);
    }

    public static class SpriteSheetBuilder {
        private BufferedImage image;
        private int rows, cols;
        private int spriteWidth, spriteHeight;
        private int spriteCount;
        public SpriteSheetBuilder(BufferedImage image) {
            this.image = image;
        }
        public SpriteSheetBuilder col(int cols){
            this.cols = cols;
            return this;
        }
        public SpriteSheetBuilder row(int rows){
            this.rows = rows;
            return this;
        }
        public SpriteSheetBuilder count(int spriteCount){
            this.spriteCount = spriteCount;
            return this;
        }
        public SpriteSheetBuilder setSpriteSize(int spriteWidth,int spriteHeight){
            this.spriteWidth = spriteWidth;
            this.spriteHeight = spriteHeight;
            return this;
        }
        public SpriteSheet build(){
            if(image == null) throw new RuntimeException("Image Resource File not null");
            int width = spriteWidth;
            int height = spriteHeight;

            if (width == 0) {
                width = image.getWidth() / cols;
            }
            if (height == 0) {
                height = image.getHeight() / rows;
            }
            if(spriteCount == 0){
                spriteCount = rows * cols;
            }
            SpriteSheet spriteSheet = new SpriteSheet();
            int x = 0;
            int y = 0;
            for (int index = 0; index < spriteCount; index++) {
                spriteSheet.add(image.getSubimage(x, y, width, height));
                x += width;
                if (x >= width * cols) {
                    x = 0;
                    y += height;

                }
            }
            return spriteSheet;
        }
    }
}
