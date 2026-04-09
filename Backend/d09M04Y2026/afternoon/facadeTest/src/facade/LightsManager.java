package facade;

import model.*;

public class LightsManager {
    private LivingRoomLight livingRoom;
    private KitchenLight kitchen;

    public LightsManager() {
        livingRoom = new LivingRoomLight();
        kitchen = new KitchenLight();
    }

    public void turnOnAllLights() {
        livingRoom.turnOn();
        kitchen.turnOn();
    }

    public void turnOnLivingRoomLight() {
        livingRoom.turnOn();
    }

    public void turnOnKitchenLight() {
        kitchen.turnOn();
    }
}
