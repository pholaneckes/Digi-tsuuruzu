package top.codephon.digi_tsuuruzu.utils;

import net.minecraft.util.math.AxisAlignedBB;

public class Matrix3 {
    public Vector3[] rows;
    int size;

    public static AxisAlignedBB getAABB(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return new AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ);
    }

    public Matrix3() {
        this.rows = new Vector3[3];
        this.size = 3;
        this.rows[0] = Vector3.getNewVector();
        this.rows[1] = Vector3.getNewVector();
        this.rows[2] = Vector3.getNewVector();
    }


    public Vector3 get(int i) {
        assert i < 3;

        return this.rows[i];
    }

    public double get(int i, int j) {
        assert i < 3;

        return this.rows[i].get(j);
    }

    public String toString() {
        String eol = System.getProperty("line.separator");
        return eol + "0: " + this.rows[0].toString() + eol + "1: " + this.rows[1].toString() + eol + "2 : " + this.rows[2].toString();
    }
}

