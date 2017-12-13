package com.sabel.IhrName;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GBSBlockchain {

    private List<Block> blocks;

    public GBSBlockchain() {
        blocks = new ArrayList<>();
        this.readBlocks();
    }

    private void readBlocks() {
        BlockService blockService = new BlockService();
        List<Block> allBlocks = blockService.getAllBlocks();
        blockService.close();

        Block block0 = findNextBlock("0", allBlocks);
        blocks.add(block0);
        System.out.println(block0.getPrev_hash());
        Block nextBlock = block0;
        while ((nextBlock = findNextBlock(block0.getSelf_hash(), allBlocks)) != null) {
            blocks.add(nextBlock);
        }
    }

    private Block findNextBlock(String hash, List<Block> blocks) {
        for (Block block : blocks) {
            if (block.getPrev_hash().equals(hash)) {
                return block;
            }
        }
        return null;
    }

    public void printData() {
        for (Block block : blocks) {
            System.out.print(block.getData() + " ");
        }
        System.out.println();
    }

}
