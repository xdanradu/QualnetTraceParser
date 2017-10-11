	 public class Packet {
		private Header header;
		private String actionType;
		private Level level;
		
		public Header getHeader() {
			return header;
		}

		public void setHeader(Header header) {
			this.header = header;
		}

		public String getActionType() {
			return actionType;
		}

		public void setActionType(String actionType) {
			this.actionType = actionType;
		}

		public Level getLevel() {
			return level;
		}

		public void setLevel(Level level) {
			this.level = level;
		}

		public Packet(Header header, String actionType, Level level) {
			this.header = header;
			this.actionType = actionType;
			this.level = level;
		}
	 }


