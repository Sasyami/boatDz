package sasyami.boat.Types;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.SqlTypes;
import org.hibernate.usertype.UserType;
import org.springframework.data.geo.Point;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PointType implements UserType<Point> {

    @Override
    public int getSqlType() {
        return SqlTypes.GEOGRAPHY;
    }

    @Override
    public Class<Point> returnedClass() {
        return Point.class;
    }

    @Override
    public boolean equals(Point x, Point y) {
        if (x==y){
            return true;
        }
        if (x!=null && y!=null){
            return (x.getX()==y.getX() && x.getY()==y.getY());
        }
        return false;
    }

    @Override
    public int hashCode(Point x) {
        return x.hashCode();
    }

    @Override
    public Point nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner) throws SQLException {
        String value = rs.getString("coordinates");
        return rs.wasNull()? null:stringToPoint(value);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Point value, int index, SharedSessionContractImplementor session) throws SQLException {
        if ( value == null ) {
              st.setNull(index, SqlTypes.VARCHAR);
        }
        else {
              st.setString(index, value.toString());
        }
    }

    @Override
    public Point deepCopy(Point value) {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Point value) {
        return value;
    }

    @Override
    public Point assemble(Serializable cached, Object owner) {
        return (Point)cached;
    }
    public static class CompositePointEmbeddable {
        private float lat;
        private float lon;
    }

    private Point stringToPoint(String str){
        return new Point(Float.parseFloat(str.substring(1,str.indexOf(","))),Float.parseFloat(str.substring(str.indexOf(",")+1,str.length()-1)));
    }
}


