package com.commerce.application.helpers;

import com.commerce.application.dto.Coordinates;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public  class GeographicPointManager {

    private static final GeometryFactory geometryFactory = new GeometryFactory();

    public static Point createGeographicPoint(Coordinates coordinates){
        return geometryFactory.createPoint(new Coordinate(coordinates.latitud(), coordinates.longitud()));
    }

    public static Coordinates getCoordinate(Point point){
        return new Coordinates(point.getY(), point.getX());
    }
}
