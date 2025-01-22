import { main_gui } from "./menu/main-gui";
import { profile } from "./menu/profile/profile";
import { inventory_gui } from "./menu/inventory/inventory-gui";
import { stats } from "./menu/stats/stats";
import { skills } from "./menu/skills/skills";
import { talents } from "./menu/talents/talents";
import { main_hud } from "./hud/player-hud";
import { Players } from "@rbxts/services";

const player = Players.LocalPlayer;

export class Player_Gui {
	main() {
		const player_gui = player.FindFirstChild("PlayerGui");
		if (player_gui) {
			const gui = player_gui.FindFirstChild("GuiScreen");
			if (!gui) {
				main_gui();
			} else {
				gui.Destroy();
			}
		}
	}

	player_gui_check(): Boolean {
		const player_gui = player.FindFirstChild("PlayerGui");
		if (player_gui) {
			const gui = player_gui.FindFirstChild("GuiScreen");
			if (gui) {
				return true;
			}
		}
		return false;
	}

	main_hud() {
		main_hud();
	}

	profile_gui() {
		if (!this.player_gui_check()) {
			this.main();
		}

		profile();
	}

	inventory_gui() {
		if (!this.player_gui_check()) {
			this.main();
		}

		inventory_gui();
	}

	stats_gui() {
		if (!this.player_gui_check()) {
			this.main();
		}

		stats();
	}

	skills_gui() {
		if (!this.player_gui_check()) {
			this.main();
		}

		skills();
	}

	talents_gui() {
		if (!this.player_gui_check()) {
			this.main();
		}

		talents();
	}
}
