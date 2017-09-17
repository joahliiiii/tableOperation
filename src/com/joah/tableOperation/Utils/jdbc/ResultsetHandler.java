package com.joah.tableOperation.Utils.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultsetHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
