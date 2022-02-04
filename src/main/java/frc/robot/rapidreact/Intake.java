package frc.robot.rapidreact;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotBase;
import frc.robot.subsystems.SubsystemBase;

public class Intake extends SubsystemBase {

	private final double INTAKE_SPEED = 1;

	private WPI_TalonSRX intake;

	public Intake(RobotBase robot) {

		super(robot);

        initMotors();

		initDefaultCommand();

	}

    private void initMotors() {
        
        intake = new WPI_TalonSRX(configInt("intake"));

        intake.setInverted(false);
    }

	public void initDefaultCommand() {

		setDefaultCommand(new CommandBase() {
		
			{
				addRequirements(Intake.this);
			}

			@Override
			public void execute() {

                if(button("intakeBall")) {
                    
                    intake.set(INTAKE_SPEED);
                } else {
                    intake.set(0);
                }
		
			}

		});

	}

	@Override
	public String getConfigName() {
		return "intake";
	}

}