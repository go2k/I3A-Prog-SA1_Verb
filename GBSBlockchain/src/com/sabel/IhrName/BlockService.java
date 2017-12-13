package com.sabel.IhrName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlockService {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BlockService() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Blockchain.db");
            preparedStatement = connection.prepareStatement("select id, timestamp, data, prev_hash, self_hash from block order by id asc");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connection = null;
    }

    public List<Block> getAllBlocks() {
        List<Block> blocks = new ArrayList<>();
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int index = resultSet.getInt(1);
                long timestamp = resultSet.getLong(2);
                String data = resultSet.getString(3);
                String pre_hash = resultSet.getString(4);
                String self_hash = resultSet.getString(5);
                Block block = new Block(index, timestamp, data, pre_hash);
                if (self_hash.equals(block.getSelf_hash())) {
                    blocks.add(block);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blocks;
    }

    public static void main(String[] args) {
        BlockService blockService = null;
        blockService = new BlockService();
        List<Block> allBlocks = blockService.getAllBlocks();
        blockService.close();
        for (Block block : allBlocks) {
            System.out.println(block.getIndex() + "\t" + block.getTimestamp() + "\t" + block.getData() + "\t" + block.getPrev_hash() + "\t" + block.getSelf_hash());
        }
    }
}
