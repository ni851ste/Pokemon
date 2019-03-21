package zmaps;
import ownUtil.*;
import model.*;

public class map {
    public intTouple widthHeight;
    public mapObject[][] mapData;
    public intTouple currentPos = null;
    public player player;




    /*  Contructor for map
            0: width INTEGER > 2
            1: height INTEGER > 2
            throws IndexNotFittingException
            returns map with
                IntTouple width height
                boolean [][] with squareData */
    public map(int width, int height) throws IndexNotFittingException {
        if (width < 3 | height < 3){
            throw new IndexNotFittingException();
        }
        this.widthHeight = new intTouple(width, height);
        this.mapData = new mapObject[width][height];
        this.currentPos = new intTouple(width / 2, height / 2);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 | i == width - 1 | j == 0 | j == height - 1){
                    mapData[i][j] = new tree();
                } else {
                    mapData[i][j] = new free();
                }
            }
        }
    }


    public void changePosition (int widthPos, int heightPos) throws IndexNotFittingException{
        if (!isMapBlockInBounds(widthPos, heightPos)){
            throw new IndexNotFittingException();
        }
        this.currentPos.change(widthPos, heightPos);
    }

    /*
    returns true if block on map is free
    else returns false
    */
    public boolean isMapBlockFree (int w, int h){
        if (mapData[w][h] instanceof mapObjectImpassable) {
            return false;
        } else {
            return true;
        }
    }

    /*
    checks if position is in bounds of map
    returns true if it is
    False if not
     */
    public boolean isMapBlockInBounds (int w, int h){
        if (    w < 0 | w >= widthHeight.get(0) |
                h < 0 | h >= widthHeight.get(1)) {
            return false;
        } else {
            return true;
        }
    }

    public mapObject specMapObject(int w, int h){
        if (!this.isMapBlockInBounds(w, h)){
            return null;
        } else if (this.currentPos.get(0) == w && this.currentPos.get(1) == h) {
            return this.player;
        } else {
            return mapData[w][h];
        }
    }

}
