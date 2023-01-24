public class Main {
    public static void main(String[] args) {
        LightGrid christmasLights = performInstructions();
        generateResults(christmasLights);
    }

    private static LightGrid performInstructions(){
        LightGrid lights = new LightGrid();
        lights.turnOn(new Area(887,9,959,629));
        lights.turnOn(new Area(454,398,844,448));
        lights.turnOff(new Area(539,243,559,965));
        lights.turnOff(new Area(370,819,676,868));
        lights.turnOff(new Area(145,40,370,997));
        lights.turnOff(new Area(301,3,808,453));
        lights.turnOn(new Area(351,678,951,908));
        lights.toggle(new Area(720,196,897,994));
        lights.toggle(new Area(831,394,904,860));
        return lights;
    }

    private static void generateResults(LightGrid lights){
        System.out.println(lights.getTotalLightsLit());
    }
}