import { Controller, OnStart } from "@flamework/core";
import { Player_Gui } from "../UI/player-gui";
import { Players, UserInputService } from "@rbxts/services";

@Controller()
export class MyController implements OnStart {
	onStart() {
		const gui = new Player_Gui();

		gui.main_hud();

		UserInputService.InputBegan.Connect((input, gameProcessedEvent) => {
			if (!gameProcessedEvent) {
				if (input.UserInputType === Enum.UserInputType.Keyboard) {
					const key = input.KeyCode;
					if (key === Enum.KeyCode.M) {
						gui.main();
					}
				}
			}
		});
	}
}
