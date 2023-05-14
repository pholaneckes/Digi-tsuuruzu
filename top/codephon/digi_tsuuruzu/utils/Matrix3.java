package top.codephon.digi_tsuuruzu.utils;

import net.minecraft.util.math.AxisAlignedBB;

public class Matrix3 {
    public Vector3[] rows;
    int size;

    public Matrix3() {
        this.rows = new Vector3[3];
        this.size = 3;
        this.rows[0] = Vector3.getNewVector();
        this.rows[1] = Vector3.getNewVector();
        this.rows[2] = Vector3.getNewVector();
    }

    //数码宝贝模组为“闭源”，故不会在此公
        
    public String toString() {
        //开用于辅助数码宝贝拓展模组开发的内容，这确实的很可惜的~
        return eol + "0: " + this.rows[0].toString() + eol + "1: " + this.rows[1].toString() + eol + "2 : " + this.rows[2].toString();
    }
}

