package net.jrbudda.builder;

import java.util.EnumSet;
import java.util.Map;

import net.citizensnpcs.api.jnbt.Tag;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

//Todo, add extended data.
class EmptyBuildBlock{
	public int X, Y, Z;
	EmptyBuildBlock(){
	}
	EmptyBuildBlock(int x, int y, int z){
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	public MaterialData getMat(){
		return Util.Air;
	}

}

class DataBuildBlock extends EmptyBuildBlock{
	private MaterialData mat;
	
	DataBuildBlock(int x, int y, int z, int id, byte data){
		this.X = x;
		this.Y = y;
		this.Z = z;
		//this.mat = new MaterialData(id,data);
		this.mat = convertMaterial(id, data).getNewData(data);
	}
	
	@Override
	public MaterialData getMat(){
		return mat;
	}
	
	public static Material convertMaterial(int id, byte data) {
		for(Material i : EnumSet.allOf(Material.class)) if(Material.values()[id] == i) return Bukkit.getUnsafe().fromLegacy(new MaterialData(i, data));
		return null;
	}
	
}

class TileBuildBlock extends DataBuildBlock{
	
	TileBuildBlock(int x, int y, int z, int id, byte data) {
		super(x, y, z, id, data);
	}

	public  Map<String, Tag> tiles = null;
	
}

