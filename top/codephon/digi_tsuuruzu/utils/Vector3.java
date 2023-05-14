package top.codephon.digi_tsuuruzu.utils;

import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.entity.PartEntity;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Vector3 {
    public double x;
    public double y;
    public double z;

    public static Vector3 entity(Entity e) {
        return e != null ? getNewVector().set(e.getX(), e.getY() + (double)e.getEyeHeight(), e.getZ()) : null;
    }

    public static Vector3 getNewVector() {
        return new Vector3();
    }

    private Vector3() {
        this.x = this.y = this.z = 0.0;
    }

    //数码宝贝模组为“闭源”，故不会在此公开用于辅助数码宝贝拓展模组开发的内容，这确实的很可惜的~

    public String toString() {
        return "x:" + this.x + " y:" + this.y + " z:" + this.z;
    }

        public void set(int x0, int y0, int z0) {
            this.x = x0;
            this.y = y0;
            this.z = z0;
        }

    }

