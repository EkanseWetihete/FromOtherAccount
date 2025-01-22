import Roact from "@rbxts/roact";
import { Players } from "@rbxts/services";

type FontType = "Ubuntu" | "Arial" | "SourceSans" | "Bodoni";

export const ElementProps = {
	TextSize: 25,
	Font: "SourceSans" as FontType,
	BackgroundTransparency: 1,
	TextStrokeTransparency: 0,
	TextColor3: new Color3(255, 255, 255),
	TextStrokeColor3: new Color3(0, 0, 0),
	TextXAlignment: Enum.TextXAlignment.Left,
	AnchorPoint: new Vector2(0, 0),
	ZIndex: 2,
};

export function main_hud() {
	const LocalPlayer = Players.LocalPlayer as Player;
	const PlayerGui = LocalPlayer.FindFirstChildOfClass("PlayerGui");

	let player_resource;

	const resource_type = "Magic";

	if (resource_type === ("Magic" as string)) {
		player_resource = new Color3(0.1, 0.32, 0.94);
	} else {
		player_resource = new Color3(0.54, 0.53, 0.29);
	}

	const tree = (
		<screengui Key={"HUD_Screen"}>
			<frame
				Key="PlayerHUD"
				Size={new UDim2(0, 400, 0, 80)}
				Position={new UDim2(0, 20, 0, -40)}
				AnchorPoint={new Vector2(0, 0)}
				Transparency={1}
			>
				<frame
					Key="HealthBarFrame"
					Size={new UDim2(0, 400, 0, 25)}
					Position={new UDim2(0, 0, 0, 0)}
					AnchorPoint={new Vector2(0, 0)}
				>
					<frame
						Key="HealthBar"
						Size={new UDim2(1, 0, 1, 0)}
						BackgroundColor3={new Color3(0.16, 0.55, 0.1)}
						AnchorPoint={new Vector2(0, 0)}
					>
						<frame
							Key="HealthBarDecoration"
							BorderSizePixel={0}
							Size={new UDim2(1, 0, 0.4, 0)}
							BackgroundColor3={new Color3(0.3, 0.66, 0.25)}
						></frame>
					</frame>
					<textlabel
						Key="HealthText"
						Size={new UDim2(0, 100, 0, 50)}
						Position={new UDim2(0.5, -10, -0.5, 1)}
						Text={"0/0"}
						{...ElementProps}
					></textlabel>

					<textlabel
						Key="LevelText"
						Size={new UDim2(1, 300, 0, 25)}
						Position={new UDim2(1, 10, 0, 0)}
						Text={"Level: 0"}
						{...ElementProps}
					></textlabel>
				</frame>

				<frame
					Key="ResourceBarFrame"
					Size={new UDim2(0, 400, 0, 25)}
					Position={new UDim2(0, 0, 0, 30)}
					AnchorPoint={new Vector2(0, 0)}
				>
					<frame
						Key="ResourceBar"
						Size={new UDim2(1, 0, 1, 0)}
						Position={new UDim2(0, 0, 0, 0)}
						AnchorPoint={new Vector2(0, 0)}
						BackgroundColor3={player_resource}
					>
						<frame
							Key="ResourceBarDecoration"
							BorderSizePixel={0}
							Size={new UDim2(1, 0, 0.4, 0)}
							BackgroundColor3={new Color3(0.3, 0.37, 0.84)}
						></frame>
					</frame>
					<textlabel
						Key="ResourceText"
						Size={new UDim2(0, 100, 0, 50)}
						Position={new UDim2(0.5, -10, -0.5, 1)}
						Text={"0/0"}
						{...ElementProps}
					></textlabel>
					<textlabel
						Key="XpText"
						Size={new UDim2(1, 300, 0, 25)}
						Position={new UDim2(1, 10, 0, 0)}
						Text={"Xp: 0/0"}
						{...ElementProps}
					></textlabel>
				</frame>

				<frame
					Key="XpBarFrame"
					Size={new UDim2(0, 400, 0, 10)}
					Position={new UDim2(0, 0, 0, 60)}
					AnchorPoint={new Vector2(0, 0)}
				>
					<frame
						Key="XpBar"
						Size={new UDim2(1, 0, 1, 0)}
						Position={new UDim2(0, 0, 0, 0)}
						AnchorPoint={new Vector2(0, 0)}
						BackgroundColor3={new Color3(0.96, 0.96, 0.11)}
					>
						<frame
							Key="XpBarDecoration"
							BorderSizePixel={0}
							Size={new UDim2(1, 0, 0.4, 0)}
							BackgroundColor3={new Color3(0.94, 0.94, 0.49)}
						></frame>
					</frame>
				</frame>
			</frame>
		</screengui>
	);

	Roact.mount(tree, PlayerGui, "screenGUI");

	if (PlayerGui) {
		print("");
	}
}
