import java.util.Arrays;

public class LightGrid {
    private static int[][] lightsGrid = new int[1000][1000];

    public int getTotalLightsLit(){
        return (int) Arrays.stream(lightsGrid)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i == 1)
                .count();
    }

    public void turnOn(Area area){
        applyActionToArea(new LightsOn(), area);
    }

    public void turnOff(Area area){
        applyActionToArea(new LightsOff(), area);
    }

    public void toggle(Area area){
        applyActionToArea(new LightsToggle(), area);
    }

    private static void applyActionToArea(LightsChange instructor, Area area){
        for(int x = area.getX1(); x <= area.getX2(); x++){
            for(int y = area.getY1(); y <= area.getY2(); y++){
                lightsGrid[x][y] = instructor.performAction(lightsGrid[x][y]);
            }
        }
    }

    private class LightsOn implements LightsChange{
        @Override
        public int performAction(int itemValue) {
            return 1;
        }
    }

    private class LightsOff implements LightsChange{
        @Override
        public int performAction(int itemValue) {
            return 0;
        }
    }

    private class LightsToggle implements LightsChange{
        @Override
        public int performAction(int itemValue) {
            return Math.max(0,Math.abs(itemValue-1));
        }
    }
}


