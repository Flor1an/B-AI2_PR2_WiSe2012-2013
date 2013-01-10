package imagefilter;


enum Filter {
	BLUR("BLUR") {

		@Override
		int[][] getContent() {
			// TODO Auto-generated method stub
			return new int[][]{ 
					{0, 0, 0, 1, 0, 0, 0},
					{0, 0, 1, 1, 1, 0, 0},
					{0, 1, 1, 1, 1, 1, 0},
					{1, 1, 1, 1, 1, 1, 1},
					{0, 1, 1, 1, 1, 1, 0},
					{0, 0, 1, 1, 1, 0, 0},
					{0, 0, 0, 1, 0, 0, 0}
			};
		}
	},

	MOTION_BLUR("MOTION_BLUR") {

		@Override
		int[][] getContent() {
			// TODO Auto-generated method stub
			return new int[][]{
					{1, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 1, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 1, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 1, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 1, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 1, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 1}
			};
		}
	},

	EDGE_DETECT("EDGE_DETECT") {
		@Override
		int[][] getContent() {
			return new int[][]{
					{-1, -1, -1},
					{-1, +8, -1},
					{-1, -1, -1}
			};
		}
	},

	IDENTITY("IDENTITY") {

		@Override
		int[][] getContent() {
			// TODO Auto-generated method stub
			return new int[][]{
					{0, 0, 0},
					{0, 1, 0},
					{0, 0, 0}
			};
		}
	};

	
	 abstract int[][] getContent();
	 private String name;
	 private Filter(String name) {
		this.name = name;
	}
	 public String toString() {
		 return name;
	 }
}
