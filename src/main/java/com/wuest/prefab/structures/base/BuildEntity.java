package com.wuest.prefab.structures.base;

import com.google.gson.annotations.Expose;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

/**
 * This class is used to define the necessary properties to describe an entity to be generated when a structure is
 * created in the world.
 *
 * @author WustMan
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BuildEntity {
	@Expose
	public double entityXAxisOffset;
	@Expose
	public double entityYAxisOffset;
	@Expose
	public double entityZAxisOffset;
	@Expose
	public String entityFacing;
	@Expose
	private int entityId;
	@Expose
	private String entityResourceLocation;
	@Expose
	private PositionOffset startingPosition;
	@Expose
	private String entityNBTData;

	/**
	 * Initializes a new instance of the BuildEntity class.
	 */
	public BuildEntity() {
		this.Initialize();
	}

	public int getEntityId() {
		return this.entityId;
	}

	public void setEntityId(int value) {
		this.entityId = value;
	}

	public String getEntityResourceString() {
		return this.entityResourceLocation;
	}

	public void setEntityResourceString(String value) {
		this.entityResourceLocation = value;
	}

	public void setEntityResourceString(Identifier value) {
		this.entityResourceLocation = value.toString();
	}

	public Identifier getEntityResource() {
		return new Identifier(this.entityResourceLocation);
	}

	public PositionOffset getStartingPosition() {
		return this.startingPosition;
	}

	public void setStartingPosition(PositionOffset value) {
		this.startingPosition = value;
	}

	public String getEntityNBTData() {
		return this.entityNBTData;
	}

	public void setEntityNBTData(String value) {
		this.entityNBTData = value;
	}

	public void setEntityNBTData(NbtCompound tagCompound) {
		this.entityNBTData = tagCompound.toString();
	}

	/**
	 * Initializes any properties to their default properties.
	 */
	public void Initialize() {
		this.entityId = 0;
		this.startingPosition = new PositionOffset();
		this.entityNBTData = "";
		this.entityXAxisOffset = 0;
		this.entityYAxisOffset = 0;
		this.entityZAxisOffset = 0;
		this.entityFacing = Direction.NORTH.asString();
	}

	public NbtCompound getEntityDataTag() {
		NbtCompound tag = null;

		if (!this.entityNBTData.equals("")) {
			try {
				tag = StringNbtReader.parse(this.entityNBTData);
			} catch (CommandSyntaxException e) {
				e.printStackTrace();
			}
		}

		return tag;
	}

}
