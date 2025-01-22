import { Controller, OnStart, OnRender } from "@flamework/core";
import { Players, Workspace, TweenService } from "@rbxts/services";

enum CameraMode {
	FollowCharacter = "FollowCharacter",
}

const player: Player = Players.LocalPlayer;

@Controller()
export class CameraController implements OnStart, OnRender {
	private character: undefined | Model = undefined;
	private camera: undefined | Camera = undefined;

	private cameraMode: CameraMode | undefined = undefined;

	private setCameraMode(cameraMode: CameraMode): void {
		this.cameraMode = cameraMode;
	}

	public async onStart(): Promise<void> {
		await new Promise((resolve) => player.CharacterAdded.Connect(resolve));

		this.character = player.Character;
		this.camera = Workspace.CurrentCamera;

		if (this.camera) {
			this.camera.CameraType = Enum.CameraType.Scriptable;
		}

		this.setCameraMode(CameraMode.FollowCharacter);

		player.CharacterAdded.Connect((character) => {
			this.character = character;
		});
	}

	public onRender(): void {
		if (this.character && this.character.PrimaryPart && this.camera) {
			if (this.cameraMode === CameraMode.FollowCharacter) {
				const tweenInfo = new TweenInfo(0.35);
				const propertyTable = {
					CFrame: new CFrame(
						this.character.PrimaryPart.CFrame.X,
						25,
						this.character.PrimaryPart.CFrame.Z + 25,
					).mul(CFrame.Angles(math.rad(-45), 0, 0)),
				};

				const tween = TweenService.Create(this.camera, tweenInfo, propertyTable);
				tween.Play();
			}
		}
	}
}
