package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private int size; 

    public Grid getGrid(){return grid;}
    public Player getPlayer(){return player;}
    public Enemy[] getEnemies(){return enemies;}
    public Treasure[] getTreasures(){return treasures;}
    public int getSize(){return size;}

    public Game(int size){
        this.size = size;
        this.initialize();
        this.play();
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            grid.display();
            System.out.println(player.getCoords());
            System.out.print("Enter a direction (w,a,s,d) or 'quit' to exit: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if(input.equals("w")){
                player.move(input);
                grid.placeSprite(player);
            }else if(input.equals("a")){
                player.move(input);
                grid.placeSprite(player);
            }else if (input.equals("s")){
                player.move(input);
                grid.placeSprite(player);
            }else if (input.equals("d")){
                player.move(input);
                grid.placeSprite(player);
            }
        }
    }

    public void initialize(){
        player = new Player (0,0);
        grid = new Grid(size);

        grid.placeSprite(player);

        enemies = new Enemy[3];
        enemies[0] = new Enemy(5, 5);
        enemies[1] = new Enemy(7, 2);
        enemies[2] = new Enemy(3, 8);
        for (Enemy enemy : enemies) {
            grid.placeSprite(enemy);
        }

        treasures = new Treasure[2];
        treasures[0] = new Treasure(2, 2);
        treasures[1] = new Treasure(8, 8);
        for (Treasure treasure : treasures) {
            grid.placeSprite(treasure);
        }
    }

    public int generateCoord(){
        return (int) (Math.random()*(size-0)+0); //generate 0-size (exclusive)
    }

    public static void main(String[] args) {
        Game g = new Game(10);
        
    }
}