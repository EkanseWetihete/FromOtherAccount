import { OnStart, Service } from "@flamework/core";

@Service()
export class DungeonGenerationService implements OnStart {
	private createGrid(size: number) {
		const grid: Record<number, Record<number, number>> = {};

		for (let row: number = 1; row <= 100; row++) {
			grid[row] = {};
			for (let column: number = 1; column <= 100; column++) {
				grid[row][column] = column;
			}
		}

		return grid;
	}

	private generateDungeon(): void {
		const grid = this.createGrid(100);
	}

	public onStart(): void {
		this.generateDungeon();
	}
}
