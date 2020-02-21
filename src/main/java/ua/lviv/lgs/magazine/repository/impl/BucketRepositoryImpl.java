package ua.lviv.lgs.repository.impl;

import ua.lviv.lgs.connection.ConnectionManager;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.repository.BucketRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BucketRepositoryImpl implements BucketRepository {

    private static String READ_ALL = "select * from bucket";
    private static String CREATE = "insert into bucket(`user_id`, `product_id`, `purchase_date`) values (?,?,?)";
    private static String READ_BY_ID = "select * from bucket where id =?";
    private static String DELETE_BY_ID = "delete from bucket where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BucketRepositoryImpl() {
        connection = ConnectionManager.openConnection();
    }

    @Override
    public Bucket save(Bucket bucket) {

        try (PreparedStatement preparedStatement = getPreparedStatement(bucket);
             ResultSet rs = preparedStatement.getGeneratedKeys()) {
            rs.next();
            bucket.setId(rs.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucket;
    }

    private PreparedStatement getPreparedStatement(Bucket bucket) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
        connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, bucket.getUserId());
        preparedStatement.setInt(2, bucket.getProductId());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(bucket.getPurchaseDate()));
        preparedStatement.executeUpdate();
        return preparedStatement;
    }

    @Override
    public Bucket findById(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer bucketId = result.getInt("id");
            Integer userId = result.getInt("user_id");
            Integer productId = result.getInt("product_id");
            LocalDateTime purchaseDate = result.getTimestamp("purchase_date").toLocalDateTime();

            bucket = new Bucket(bucketId, userId, productId, purchaseDate);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket update(Bucket t) {
        throw new IllegalStateException("there is no update for bucket");
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bucket> findAll() {

        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer bucketId = result.getInt("id");
                Integer userId = result.getInt("user_id");
                Integer productId = result.getInt("product_id");
                LocalDateTime purchaseDate = result.getTimestamp("purchase_date").toLocalDateTime();
                bucketRecords.add(new Bucket(bucketId, userId, productId, purchaseDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucketRecords;
    }
}
