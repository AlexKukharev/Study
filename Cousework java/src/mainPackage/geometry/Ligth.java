package mainPackage.geometry;


public class Ligth {
    private double coordinates[];
    private boolean IsLight = false;
    private Point light = null;
    private boolean IsProjection= false;

    public Ligth(double x, double y, double z) {
        coordinates = new double[]{x, y, z};
    }

    public Ligth(Point point1, Point point2, Point point3) {
        var isVisable = true;
        double result;
        double i1 = point2.getX() - point1.getX();
        double i2 = point3.getX() - point1.getX();
        double j1 = point2.getY() - point1.getY();
        double j2 = point3.getY() - point1.getY();
        double k1 = point2.getZ() - point1.getZ();
        double k2 = point3.getZ() - point1.getZ();


        double x = j1 * k2 - k1 * j2;
        double y = k1 * i2 - i1 * k2;
        double z = i1 * j2 - j1 * i2;

       double visableNormalX = 0;
       double visableNormalY = 0;
       double visableNormalZ = -1000;

        double normalLenght = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));

        double visNormalLength = Math.sqrt(Math.pow(visableNormalX, 2) + Math.pow(visableNormalY, 2) +
                Math.pow(visableNormalZ, 2));

        if (normalLenght == 0 || visNormalLength == 0) {
            result = -1;
        } else {
            result = (x * visableNormalX + y * visableNormalY + z * visableNormalZ) /
                    (normalLenght * visNormalLength);
        }
        isVisable = (result > 0);
       /** if (IsLight && !IsProjection) {
            visNormalLength = Math.sqrt(Math.pow(LightPosition.X, 2) + Math.pow(LightPosition.Y, 2) +
                    Math.pow(LightPosition.Z, 2));
            normalLenght = normalLenght == 0 ? 0.0001 : normalLenght;
            visNormalLength = visNormalLength == 0 ? 0.0001 : visNormalLength;
            result = (x * LightPosition.X + y * LightPosition.Y + z * LightPosition.Z) /
                    (normalLenght * visNormalLength);
            edge.Color = Color.FromArgb((int) (edge.BaseColor.R * (0.5 + 0.5 * result)),
                    (int) (edge.BaseColor.G * (0.5 + 0.5 * result)),
                    (int) (edge.BaseColor.B * (0.5 + 0.5 * result)));
        }
        return isVisable;*/
    }


}
