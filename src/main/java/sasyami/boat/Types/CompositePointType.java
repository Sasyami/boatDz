package sasyami.boat.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.ValueAccess;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.data.geo.Point;

import java.io.Serializable;
@Deprecated
public class CompositePointType implements CompositeUserType<Point> {





    @Override
    public Class<Point> returnedClass() {
        return Point.class;
    }

    @Override
    public boolean equals(Point o1, Point o2) throws HibernateException {
        if (o1 == o2)
            return true;
        if (o1 != null && o2 != null)
            return o1.equals(o2);
        return false;
    }

    @Override
    public int hashCode(Point p) {
        return p.hashCode();
    }

    @Override
    public Point deepCopy(Point value) {
        return value;
    }

    @Override
    public Object getPropertyValue(Point object, int index)
            throws HibernateException {

        if (index == 0) {
            return object.getX();
        } else if (index == 1) {
            return object.getY();
        } else {
            throw new HibernateException("Unknown index [ " + index + " ]");
        }
    }

    @Override
    public Point instantiate(ValueAccess values, SessionFactoryImplementor sessionFactory) {
        final Float lat = values.getValue(0, Float.class);
        final Float lon = values.getValue(1,Float.class);
        if (lat==null || lon==null){
            return null;
        }
        return new Point(lat,lon);
    }

    @Override
    public Class<?> embeddable() {
        return Point.class;
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

    @Override
    public Point replace(Point detached, Point managed, Object owner) {
        return detached;
    }

    public static class CompositePointEmbeddable {
        private float lat;
        private float lon;
    }



}
