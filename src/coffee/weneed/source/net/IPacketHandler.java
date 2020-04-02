package coffee.weneed.source.net;

import java.util.List;
import coffee.weneed.source.IClient;

public interface IPacketHandler {
	
	/**
	 * A list of conditional classes to pass the packet through before running it, handled in order halting at a failed order.
	 * @return
	 */
	public List<IPacketHandlerCondition> getConditions();
	
	public PacketHandlerResult handlePacket(IPacket packet, IClient sender);
	
	public default PacketHandlerResult preHandle(IPacket packet, IClient client) {
		for (IPacketHandlerCondition c : getConditions()) {
			PacketHandlerResult result = c.willHandle(packet, client);
			if (!result.equals(PacketHandlerResult.SUCCESS)) return result; 
		}
		return PacketHandlerResult.SUCCESS;
	}
	
}
