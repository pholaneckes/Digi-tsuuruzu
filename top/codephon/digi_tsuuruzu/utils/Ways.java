package top.codephon.digi_tsuuruzu.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;

import net.minecraft.world.World;
import net.minecraftforge.entity.PartEntity;

import java.util.Iterator;
import java.util.function.Predicate;

public class Ways {
    public static Entity getPointedEntity(Entity entity, double distance) {
        return getPointedEntity(entity, distance, null);
    }
    public static Entity getCoreEntity(Entity in) {
        return in instanceof PartEntity ? ((PartEntity)in).getParent() : in;
    }

    //数码宝贝模组为“闭源”，故不会在此公开用于辅助数码宝贝拓展模组开发的内容，这确实的很可惜的~
}
