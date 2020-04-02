package coffee.weneed.source.net;

import coffee.weneed.source.IClient;

public interface IPacketHandlerCondition {
	
	public PacketHandlerResult willHandle(IPacket packet, IClient client);
}
