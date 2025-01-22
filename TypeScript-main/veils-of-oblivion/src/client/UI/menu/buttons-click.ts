import { Players } from "@rbxts/services";
import { profile } from "./profile/profile";
import { inventory_gui } from "./inventory/inventory-gui";
import { stats } from "./stats/stats";
import { skills } from "./skills/skills";
import { talents } from "./talents/talents";
import { Player_Gui } from "../player-gui";

const player = Players.LocalPlayer;

export function buttons_clicked(button: Instance) {
	const menu_frame = button.FindFirstChild("MenuFrame");
	if (menu_frame) {
		const allButtons = [...(button.GetChildren() || []), ...(menu_frame.GetChildren() || [])];
		allButtons.forEach((child) => {
			if (child.IsA("TextButton")) {
				const button = child as TextButton;
				button.MouseButton1Click.Connect(() => {
					button_function(button);
				});
			}
		});
	}
}

function button_function(button: Instance) {
	if (button.IsA("TextButton")) {
		remove_buttons(button);
		if (button.Text === "Profile") {
			profile();
		} else if (button.Text === "Inventory") {
			inventory_gui();
		} else if (button.Text === "Stats") {
			stats();
		} else if (button.Text === "Skills") {
			skills();
		} else if (button.Text === "Talents") {
			talents();
		} else if (button.Text === "X") {
			exit_button();
		}
	}
}

function exit_button() {
	const player_gui = player.FindFirstChild("PlayerGui");
	if (player_gui) {
		const gui = player_gui.FindFirstChild("GuiScreen");
		if (gui) {
			gui.Destroy();
		}
	}
}

function remove_buttons(button: Instance) {
	const menu_frame = button.Parent;
	if (menu_frame) {
		menu_frame.Destroy();
	}
}
