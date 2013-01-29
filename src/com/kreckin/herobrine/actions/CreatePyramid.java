package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.Action;
import com.kreckin.herobrine.impl.ActionResult;
import com.kreckin.herobrine.impl.ActionType;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class CreatePyramid extends Action {

    public CreatePyramid() {
        super(ActionType.STANDARD);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        Block[] blocks = new Block[14];
        blocks[0] = Util.getNearbyLocation(player, 25).add(0, 2, 0).getBlock();
        blocks[1] = blocks[0].getRelative(BlockFace.NORTH).getLocation().subtract(0, 1, 0).getBlock();
        blocks[2] = blocks[0].getRelative(BlockFace.SOUTH).getLocation().subtract(0, 1, 0).getBlock();
        blocks[3] = blocks[0].getRelative(BlockFace.WEST).getLocation().subtract(0, 1, 0).getBlock();
        blocks[4] = blocks[0].getRelative(BlockFace.EAST).getLocation().subtract(0, 1, 0).getBlock();
        blocks[5] = blocks[1].getRelative(BlockFace.NORTH).getLocation().subtract(0, 1, 0).getBlock();
        blocks[6] = blocks[2].getRelative(BlockFace.SOUTH).getLocation().subtract(0, 1, 0).getBlock();
        blocks[7] = blocks[3].getRelative(BlockFace.WEST).getLocation().subtract(0, 1, 0).getBlock();
        blocks[8] = blocks[4].getRelative(BlockFace.EAST).getLocation().subtract(0, 1, 0).getBlock();
        blocks[9] = blocks[0].getRelative(BlockFace.NORTH_EAST).getLocation().subtract(0, 2, 0).getBlock();
        blocks[10] = blocks[0].getRelative(BlockFace.SOUTH_EAST).getLocation().subtract(0, 2, 0).getBlock();
        blocks[11] = blocks[0].getRelative(BlockFace.SOUTH_WEST).getLocation().subtract(0, 2, 0).getBlock();
        blocks[12] = blocks[0].getRelative(BlockFace.NORTH_WEST).getLocation().subtract(0, 2, 0).getBlock();
        blocks[13] = blocks[0].getLocation().subtract(0, 1, 0).getBlock();
        for (int index = 0; index < blocks.length; index++) {
            Block block = blocks[index];
            if (index >= 5 && index <= 12) {
                if (Util.isSolid(block.getLocation().subtract(0, 1, 0).getBlock()) || player.getLocation().distance(block.getLocation()) <= 1F) {
                    return (new ActionResult("Failed, could not find a proper location!"));
                }
            }
        }
        for (int index = 0; index < blocks.length; index++) {
            Block block = blocks[index];
            if (index == 13) {
                block.setType(Material.NETHERRACK);
                blocks[0].setType(Material.FIRE);
            } else {
                block.setType(Material.SANDSTONE);
            }
        }
        Location loc = blocks[0].getLocation();
        return (new ActionResult("Done.", "Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ()));
    }
}
