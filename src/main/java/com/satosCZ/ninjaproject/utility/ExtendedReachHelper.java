package com.satosCZ.ninjaproject.utility;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

import java.util.List;

@SideOnly(Side.CLIENT)
public abstract class ExtendedReachHelper
{
    private static Minecraft mc = FMLClientHandler.instance().getClient();

    public static MovingObjectPosition getMouseOver(float frame, float dist)
    {
        MovingObjectPosition mop = null;
        if (mc.renderViewEntity != null)
        {
            if (mc.theWorld != null)
            {
                double d1 = dist;
                mop = mc.renderViewEntity.rayTrace(d1, frame);
                double caldist = d1;
                Vec3 pos = mc.renderViewEntity.getPosition(frame);
                d1 = caldist;
                if (mop != null)
                {
                    caldist = mop.hitVec.distanceTo(pos);
                }
                Vec3 playerLook = mc.renderViewEntity.getLook(frame);
                Vec3 v1 = pos.addVector(playerLook.xCoord * d1, playerLook.yCoord * d1, playerLook.zCoord * d1);
                Entity point = null;
                float fl1 = 1.0F;
                @SuppressWarnings("unchecked")
                List<Entity> list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(mc.renderViewEntity, mc.renderViewEntity.boundingBox.addCoord(playerLook.xCoord * d1, playerLook.yCoord * d1, playerLook.zCoord * d1).expand(fl1, fl1, fl1));
                double d2 = caldist;

                for (Entity entity : list)
                {
                    if (entity.canBeCollidedWith())
                    {
                        float boardsize = entity.getCollisionBorderSize();
                        AxisAlignedBB axisABB = entity.boundingBox.expand(boardsize, boardsize, boardsize);
                        MovingObjectPosition mop1 = axisABB.calculateIntercept(pos, v1);
                        if (axisABB.isVecInside(pos))
                        {
                            if (0.0D < d2 || d2 == 0.0D)
                            {
                                point = entity;
                                d2 = 0.0D;
                            } else if (mop1 != null)
                            {
                                double d3 = pos.distanceTo(mop1.hitVec);
                                if (d3 < d2 || d3 == 0.0D)
                                {
                                    point = entity;
                                    d3 = d2;
                                }
                            }
                        }
                    }
                }
                if (point != null && (d2 < caldist || mop == null))
                {
                    mop = new MovingObjectPosition(point);
                }

            }
        }
        return mop;
    }
}
