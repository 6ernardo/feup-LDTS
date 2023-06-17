package com.l14gr05.proj.model.game.arena;

import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.game.elements.*;

import java.util.List;

public class Arena {
    private int level;
    private int score;

    private int width;
    private int height;

    private Puffle puffle;

    private List<Wall> walls;
    private List<Floor> floors;
    private Key key;
    private Lock lock;
    private Coin coin;

    public Arena(int width, int height, int level, int score){
        this.width=width;
        this.height=height;
        this.level= level;
        this.score=score;
    }

    //getters
    public int getLevel() {
        return level;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Puffle getPuffle() {
        return puffle;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Coin getCoin() {
        return coin;
    }

    public Key getKey() {
        return key;
    }

    public Lock getLock() {
        return lock;
    }

    public int getScore() {
        return score;
    }

    //setters
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPuffle(Puffle puffle) {
        this.puffle = puffle;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void setKey(Key key){
        this.key=key;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isStepable(Position position){
        for(Wall wall: walls){
            if(wall.getPosition().equals(position)) return false;
        }

        for(Floor floor: floors){
            if(floor.getPosition().equals(position) && floor.getDurability()<1) return false;
        }
        if(lock!=null){
            if(lock.getPosition().equals(position) && !puffle.hasKey()) return false;
        }

        return true;
    }

    public boolean canMove(Position position){
        return isStepable(position.getUp()) || isStepable(position.getDown()) || isStepable(position.getRight()) || isStepable(position.getLeft());
    }

    public void crackFloor(Position position){
        for(Floor floor: floors){
            if(floor.getPosition().equals(position)) floor.setDurability(floor.getDurability()-1);
        }
    }

    public void pickKey(){
        if(key!=null && puffle.getPosition().equals(key.getPosition())){
            key.collectKey();
            puffle.getKey();
        }
    }

    public void pickCoin(){
        if(coin!=null && puffle.getPosition().equals(coin.getPosition())){
            coin.collectCoin();
        }
    }

    public boolean reachObjective(){

        Position obj = new Position(1,1);

        for(Floor floor : floors){
            if(floor.isObjective()) {
                obj.setX(floor.getPosition().getX());
                obj.setY(floor.getPosition().getY());
            }
        }

        return puffle.getPosition().equals(obj);
    }

}
