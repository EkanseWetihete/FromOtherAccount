import Roact from "@rbxts/roact";
import { Players } from "@rbxts/services";
import { buttons_clicked } from "./buttons-click";

type FontType = "Ubuntu" | "Arial" | "SourceSans" | "Bodoni";

export const ElementProps = {
	TextSize: 30,
	Font: "SourceSans" as FontType,
	Size: new UDim2(0.3, 0, 0, 45),
	AnchorPoint: new Vector2(0.5, 0),
	Position: new UDim2(0.5, 0, 0, 0),
};

const a = 0.05; //alignment of buttons

function calculateButtonPosition(index: number): UDim2 {
	return new UDim2(
		ElementProps.Position.X.Scale,
		ElementProps.Position.X.Offset,
		a + 0.15 * index,
		ElementProps.Position.Y.Offset,
	);
}

export function main_gui() {
	const LocalPlayer = Players.LocalPlayer as Player;
	const PlayerGui = LocalPlayer.FindFirstChildOfClass("PlayerGui");

	const tree = (
		<screengui Key={"GuiScreen"}>
			<frame
				Key="PlayerGUI"
				Size={new UDim2(0.4, 0, 0.5, 0)}
				Position={new UDim2(0.5, 0, 0.4, 0)}
				AnchorPoint={new Vector2(0.5, 0.4)}
			>
				<textlabel
					Key="Title"
					Text="Menu"
					TextSize={30}
					Size={new UDim2(1, 0, 0, 45)}
					AnchorPoint={new Vector2(0.5, 0)}
					Position={new UDim2(0.5, 0, 0, 0)}
				></textlabel>
				<textbutton
					Key="ExitButton"
					Text="X"
					TextSize={30}
					Size={new UDim2(0.1, 0, 0, 45)}
					AnchorPoint={new Vector2(1, 0)}
					Position={new UDim2(1, 0, 0, 0)}
				></textbutton>
			</frame>
		</screengui>
	);

	const tree2 = (
		<frame Key="MenuFrame" Visible={true} Transparency={1} Size={new UDim2(1, 0, 1, 0)}>
			<textbutton
				Key="ProfileButton"
				Text="Profile"
				{...ElementProps}
				Position={calculateButtonPosition(1)}
			></textbutton>
			<textbutton
				Key="InventoryButton"
				Text="Inventory"
				{...ElementProps}
				Position={calculateButtonPosition(2)}
			></textbutton>
			<textbutton
				Key="SkillsButton"
				Text="Skills"
				{...ElementProps}
				Position={calculateButtonPosition(3)}
			></textbutton>
			<textbutton
				Key="StatsButton"
				Text="Stats"
				{...ElementProps}
				Position={calculateButtonPosition(4)}
			></textbutton>
			<textbutton
				Key="TalentsButton"
				Text="Talents"
				{...ElementProps}
				Position={calculateButtonPosition(5)}
			></textbutton>
		</frame>
	);

	Roact.mount(tree, PlayerGui, "screenGUI");

	if (PlayerGui) {
		const gui2 = PlayerGui.FindFirstChild("GuiScreen");
		if (gui2) {
			const playerGUI = gui2.FindFirstChild("PlayerGUI");
			if (playerGUI) {
				Roact.mount(tree2, playerGUI);
				buttons_clicked(playerGUI);
			}
		}
	}
}
