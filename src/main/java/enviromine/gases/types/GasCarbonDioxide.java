package enviromine.gases.types;

import java.awt.Color;
import net.minecraft.entity.EntityLivingBase;
import enviromine.gases.EnviroGas;
import enviromine.handlers.EM_StatusManager;
import enviromine.trackers.EnviroDataTracker;

public class GasCarbonDioxide extends EnviroGas
{
	public GasCarbonDioxide(String name, int ID)
	{
		super(name, ID);
		this.setColor(new Color(255, 255, 255, 8));
	}
	
	public void applyEffects(EntityLivingBase entityLiving, int amplifier)
	{
		if(entityLiving.worldObj.isRemote)
		{
			return;
		}
		
		EnviroDataTracker tracker = EM_StatusManager.lookupTracker(entityLiving);
		
		if(tracker != null)
		{
			tracker.gasAirDiff -= 0.001F * amplifier;
		}
	}
}