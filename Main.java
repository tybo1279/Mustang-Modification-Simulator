import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static boolean exited = false;
  public static ArrayList<Mod> modlist = new ArrayList<Mod>();
  public static Car car;
  
  public static void main(String[] args) {
    
  //List//-------------------------------------------------------------------------------------
    EngineMod cams = new EngineMod();
    cams.setHpAdded(10);
    cams.setHpBoost(true);
    cams.setHpPotential(null);
    cams.setName("Ford Racing Hot Rod Camshafts");
    cams.setPrice(854);
    cams.setIsDependent(false);
    
    EngineMod CAI = new EngineMod();
    CAI.setHpAdded(20);
    CAI.setHpBoost(true);
    CAI.setHpPotential(null);
    CAI.setName("JLT Series 3 Cold Air Intake");
    CAI.setPrice(259);
    CAI.setIsDependent(false);
    
    EngineMod ThrottleBody = new EngineMod();
    ThrottleBody.setHpAdded(8);
    ThrottleBody.setHpBoost(false);
    ThrottleBody.setHpPotential(null);
    ThrottleBody.setName("Ford Performance Twin 62mm Throttle Body");
    ThrottleBody.setPrice(788);
    ThrottleBody.setIsDependent(true);
    
    EngineMod IntakeManifold = new EngineMod();
    IntakeManifold.setHpAdded(8);
    IntakeManifold.setHpBoost(false);
    IntakeManifold.setHpPotential(null);
    IntakeManifold.setName("Ford Performance High Performance Intake Manifold");
    IntakeManifold.setPrice(673);
    IntakeManifold.setIsDependent(true);
    
    EngineMod UnderDrivePulleys = new EngineMod();
    UnderDrivePulleys.setHpAdded(12);
    UnderDrivePulleys.setHpBoost(true);
    UnderDrivePulleys.setHpPotential(null);
    UnderDrivePulleys.setName("BBK Underdrive Pulleys");
    UnderDrivePulleys.setPrice(270);
    UnderDrivePulleys.setIsDependent(false);
    
    EngineMod ForgedLongBlock = new EngineMod();
    ForgedLongBlock.setHpAdded(0);
    ForgedLongBlock.setHpBoost(false);
    ForgedLongBlock.setHpPotential(1200);
    ForgedLongBlock.setName("Fully Forged internals and block, ported heads, and new drivetrain");
    ForgedLongBlock.setPrice(9799);
    ForgedLongBlock.setIsDependent(false);
    
    SuspensionMod LSDifferential = new SuspensionMod();
    LSDifferential.setHpAdded(0);
    LSDifferential.setHpBoost(false);
    LSDifferential.setHpPotential(null);
    LSDifferential.setIsDependent(true);
    LSDifferential.setName("Ford Performance TR300S Limited Slip Differential");
    LSDifferential.setPrice(939);
    LSDifferential.setRwhpBoost(.10);
    
    SuspensionMod RacingTires = new SuspensionMod();
    RacingTires.setHpAdded(0);
    RacingTires.setHpBoost(false);
    RacingTires.setHpPotential(800);
    RacingTires.setIsDependent(false);
    RacingTires.setName("Mickey Thompson Racing Tires");
    RacingTires.setPrice(1159);
    RacingTires.setRwhpBoost(0.0);
    
    modlist.add(IntakeManifold);
    modlist.add(ThrottleBody);
    modlist.add(CAI);
    modlist.add(cams);
    modlist.add(UnderDrivePulleys);
    modlist.add(LSDifferential);
    modlist.add(RacingTires);
    modlist.add(ForgedLongBlock);
    
    String commands = "Commands:\nti--Shows the total amount of money invested in the build\n"
        + "hp--Shows the estimated horsepower of the build\n"
        + "rwhp--Shows the estimated horsepower to the wheels\n"
        + "pot--Shows how much horsepower the current build can handle\n"
        + "mods--Shows the current mods applied to the build\n"
        + "apply--Applies a new mod to the build\n"
        + "create--creates a new project car\n"
        + "tune--tunes the car\n"
        + "exit--exits the program";
    System.out.println("MUSTANG BUILDER\n\n" + commands);
        
    while (exited == false) {
      Scanner s = new Scanner(System.in);
      String input = s.nextLine();
      if (input.equalsIgnoreCase("ti")) {
        System.out.println(car.totalInvested);
      }
      if (input.equalsIgnoreCase("hp")) {
        System.out.println(car.currHP);
      }
      if (input.equalsIgnoreCase("rwhp")) {
        System.out.println(car.rwhp);
      }
      if (input.equalsIgnoreCase("pot")) {
        System.out.println(car.hpPotential);
      }
      if (input.equalsIgnoreCase("mods")) {
        printMods(car.currMods);
      }
      if (input.equalsIgnoreCase("commands")) {
        System.out.println(commands);
      }
      if (input.equalsIgnoreCase("apply")) {
        if (modlist.isEmpty()) {
          System.out.println("No mods left to apply");
        }
        else {
        System.out.println("Choose a mod to apply");
        int count = 1;
        for (Mod m : modlist) {
          System.out.println("(" + count + "): " + m.name);
          ++count;
        }
        int num = s.nextInt();
        switch (num) {
          case 1:
            car.applyMod(modlist.get(0));
            modlist.remove(0);
            break;
          case 2:
            car.applyMod(modlist.get(1));
            modlist.remove(1);
            break;
          case 3:
            car.applyMod(modlist.get(2));
            modlist.remove(2);
            break;
          case 4:
            car.applyMod(modlist.get(3));
            modlist.remove(3);
            break;
          case 5:
            car.applyMod(modlist.get(4));
            modlist.remove(4);
            break;
          case 6:
            car.applyMod(modlist.get(5));
            modlist.remove(5);
            break;
          case 7:
            car.applyMod(modlist.get(6));
            modlist.remove(6);
            break;
          case 8:
            car.applyMod(modlist.get(7));
            modlist.remove(7);
            break;
        }
        System.out.println("Mod applied");
        }
      }
      if (input.equalsIgnoreCase("create")) {
        System.out.println("Specify a name");
        Car car1 = new Car(s.nextLine());
        car = car1;
        System.out.println("What is the base horsepower of the vehicle?");
        car1.currHP = Integer.parseInt(s.nextLine());
        car1.rwhp = (int) (car1.currHP * .85);
        car1.hpPotential = (int) (car1.currHP * 2.5);
        System.out.println("Car made. You can begin to build.");
      }
      if (input.equalsIgnoreCase("tune")) {
        car.applyTune();
        System.out.println("Car tuned");
      }
      if (input.equalsIgnoreCase("exit")) {
        s.close();
        exited = true;
        System.out.println("Application closed.");
      }
    }
  }
  
  public static void printMods(ArrayList<Mod> mods) {
    for (Mod print: mods) {
      System.out.println("-" + print.name);
    }
    System.out.println("\n");
  }

}
