package top.codephon.digi_tsuuruzu.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import mod.cyan.digimobs.Digimobs;
import mod.cyan.digimobs.entities.DigimonEntity;
import mod.cyan.digimobs.entities.setup.FieldGuide;
import mod.cyan.digimobs.entities.setup.helpers.Form;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import top.codephon.digi_tsuuruzu.Digi_tsuuruzu;
import top.codephon.digi_tsuuruzu.network.NetworkRegHandler;
import top.codephon.digi_tsuuruzu.network.SendPack;

import java.util.Objects;

import static top.codephon.digi_tsuuruzu.events.KeyListener.OpenFullDataGui;

public class DigimonFullDataScreen extends Screen {
    public static final ResourceLocation DIGIMONFULLDATASCREENTEXTURE = new ResourceLocation(Digi_tsuuruzu.MOD_ID,"textures/gui/dm_data.png");
    public static int xSize = 256;
    public static int ySize = 197;

    public static Entity digimon;

    public static String fz1, fz2, fz3, fz4, fztg;
    public static String fz0 = "no";

    protected static String typ;


    Button evo_back;
    DTrIconButton fenzhi1, fenzhi2, fenzhi3, fenzhi4, fenzhi_ima, fenLine;
    Button evo_line;
    Button full_data;

    Button addEvo1, addEvo2, addEvo3, addEvo4;

    TextFieldWidget textFieldWidget;
    public static Byte page;
    public DigimonFullDataScreen(Entity digimon, Byte page) {
        super(new TranslationTextComponent("dtr.gui.fulldata"));
        this.digimon = digimon;
        this.page = page;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouthY, float parTicks) {
        super.render(matrixStack, mouseX, mouthY, parTicks);
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(DIGIMONFULLDATASCREENTEXTURE);

        int wid = (this.width - xSize) / 2;
        int hei = (this.height - ySize) / 2;

        this.blit(matrixStack, wid, hei + 2, 0, 0, xSize, ySize);

        PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getCameraEntity();



        switch (page) {
            case 1:
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.gui"), this.width / 2 - 17, 32, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.name"), this.width / 2 - 115, 40, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.nick"), this.width / 2 - 115, 50, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.pAtt"), this.width / 2 - 115, 60, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.pSAtt"), this.width / 2 - 115, 70, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.pDef"), this.width / 2 - 115, 80, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.pSDef"), this.width / 2 - 115, 90, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.pSpe"), this.width / 2 - 115, 100, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.pLuk"), this.width / 2 - 115, 110, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.pHP"), this.width / 2 - 115, 120, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.pEG"), this.width / 2 - 115, 130, 0X0ab9ff);

                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.age"), this.width / 2 - 115, 140, 0X0ab9ff);

                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.xgene"), this.width / 2 - 115, 150, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.colorgene"), this.width / 2 - 115, 160, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.typegene"), this.width / 2 - 115, 170, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.sizegene"), this.width / 2 - 115, 180, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.attrigene"), this.width / 2 - 115, 190, 0X0ab9ff);

                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.sAtt"), this.width / 2 - 0, 60, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.sSAtt"), this.width / 2 - 0, 70, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.sDef"), this.width / 2 - 0, 80, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.sSDef"), this.width / 2 - 0, 90, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.sSpe"), this.width / 2 - 0, 100, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.sLuk"), this.width / 2 - 0, 110, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.sHP"), this.width / 2 - 0, 120, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.sEG"), this.width / 2 - 0, 130, 0X0ab9ff);

                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.vcolor"), this.width / 2 - 0, 140, 0X0ab9ff);


                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.eg"), this.width / 2 - 0, 40, 0X0ab9ff);
                drawString(matrixStack, this.font, new TranslationTextComponent("dtr.stats.hp"), this.width / 2 - 0, 50, 0X0ab9ff);



                if(digimon instanceof DigimonEntity) {
                    DigimonEntity digi = (DigimonEntity) digimon;
                    drawString(matrixStack, this.font, digi.getName(), this.width / 2 - 50, 40, 0Xff9d5a);
                    drawString(matrixStack, this.font, digi.getDigimon().getString("Nickname").equals("") ? "-" : digi.getDigimon().getString("Nickname"), this.width / 2 - 50, 50, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("PersonalityGradeATK")), this.width / 2 - 50, 60, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("PersonalityGradeSATK")), this.width / 2 - 50, 70, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("PersonalityGradeDEF")), this.width / 2 - 50, 80, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("PersonalityGradeSDEF")), this.width / 2 - 50, 90, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("PersonalityGradeSPE")), this.width / 2 - 50, 100, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("PersonalityGradeLUK")), this.width / 2 - 50, 110, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("PersonalityGradeHP")), this.width / 2 - 50, 120, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("PersonalityGradeEG")), this.width / 2 - 50, 130, 0Xff9d5a);
                    drawString(matrixStack, this.font, digi.getStats().getInt("DigimonAgeTimer") + new TranslationTextComponent("danwei.s").getString(), this.width / 2 - 50, 140, 0Xff9d5a);
                    drawString(matrixStack, this.font, digi.getStats().getCompound("Genetics").getString("XAntibodyType"), this.width / 2 - 50, 150, 0Xff9d5a);
                    drawString(matrixStack, this.font, digi.getStats().getCompound("Genetics").getString("ColorType"), this.width / 2 - 50, 160, 0Xff9d5a);
                    drawString(matrixStack, this.font, digi.getStats().getCompound("Genetics").getString("GeneticType"), this.width / 2 - 50, 170, 0Xff9d5a);
                    drawString(matrixStack, this.font, digi.getStats().getCompound("Genetics").getString("SizeType"), this.width / 2 - 50, 180, 0Xff9d5a);
                    drawString(matrixStack, this.font, digi.getStats().getCompound("Genetics").getString("AttributeType"), this.width / 2 - 50, 190, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("SpeciesGradeATK")), this.width / 2 + 65, 60, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("SpeciesGradeSATK")), this.width / 2 + 65, 70, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("SpeciesGradeDEF")), this.width / 2 + 65, 80, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("SpeciesGradeSDEF")), this.width / 2 + 65, 90, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("SpeciesGradeSPE")), this.width / 2 + 65, 100, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("SpeciesGradeLUK")), this.width / 2 + 65, 110, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("SpeciesGradeHP")), this.width / 2 + 65, 120, 0Xff9d5a);
                    drawString(matrixStack, this.font, levelStats(digi.getStats().getCompound("Grades").getInt("SpeciesGradeEG")), this.width / 2 + 65, 130, 0Xff9d5a);
                    drawString(matrixStack, this.font, digi.getStats().getInt("Energy") + " / " + digi.getStats().getInt("MaxEnergy"), this.width / 2 + 65, 40, 0Xff9d5a);
                    drawString(matrixStack, this.font, digi.getHealth() + " / " + (digi.getMaxHealth() >= 1024 ? "——" : digi.getMaxHealth()), this.width / 2 + 65, 50, 0Xff9d5a);
                    drawString(matrixStack, this.font, new TranslationTextComponent("dtr.color."+colorVPET(digi.vpetcolor)), this.width / 2 + 65, 140, 0X0ab9ff);
                }
                break;
            case 2:
                if(digimon instanceof DigimonEntity) {
                    this.fenzhi1.render(matrixStack, mouseX, mouthY, parTicks);
                    this.fenzhi2.render(matrixStack, mouseX, mouthY, parTicks);
                    this.fenzhi3.render(matrixStack, mouseX, mouthY, parTicks);
                    this.fenzhi4.render(matrixStack, mouseX, mouthY, parTicks);
                    this.evo_back.render(matrixStack, mouseX, mouthY, parTicks);
                    this.fenzhi_ima.render(matrixStack, mouseX, mouthY, parTicks);
                    this.addEvo1.render(matrixStack, mouseX, mouthY, parTicks);
                    this.addEvo2.render(matrixStack, mouseX, mouthY, parTicks);
                    this.addEvo3.render(matrixStack, mouseX, mouthY, parTicks);
                    this.addEvo4.render(matrixStack, mouseX, mouthY, parTicks);
                    this.textFieldWidget.render(matrixStack, mouseX, mouthY, parTicks);
                }
                this.fenLine.render(matrixStack, mouseX, mouthY, parTicks);
        }

        this.evo_line.render(matrixStack, mouseX, mouthY, parTicks);
        this.full_data.render(matrixStack, mouseX, mouthY, parTicks);
    }

    @Override
    protected void init() {
        super.init();
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
        this.textFieldWidget = new TextFieldWidget(this.font, this.width / 2 + 20, 7, 95, 20, new TranslationTextComponent("dtr.gui.edit"));
        this.children.add(this.textFieldWidget);
        this.evo_line = new Button(this.width / 2 - 65, 215, 50, 20, new TranslationTextComponent("gui.button.evo"), (button) -> {
            OpenFullDataGui(digimon, (byte) 2);
        });
        this.addButton(evo_line);
        this.full_data = new Button(this.width / 2 - 125, 215, 50, 20, new TranslationTextComponent("gui.button.fuldata"), (button) -> {
            OpenFullDataGui(digimon, (byte) 1);
        });
        this.addButton(full_data);
        if(digimon instanceof DigimonEntity) {
            DigimonEntity digi = (DigimonEntity)digimon;
            if(Objects.equals(fz0, "no")) {
                fz0 = Registry.ENTITY_TYPE.getKey(digi.getType()).toString().replaceAll("digimobs","").replaceAll(":","").replaceAll(" ","").toUpperCase();
            }else {
                fz0 = fz0.toUpperCase();
            }
            byte isKong = 2;
            byte typ_id = 0;
            String serializedName = FieldGuide.DigimonTypes.valueOf(fz0).getSerializedName();
            if(FieldGuide.DigimonTypes.valueOf(fz0).getForm().equals(Form.FormTypes.CHAMPION)){
                typ = "Champions";
                typ_id = 4;
                isKong = 1;
                fz1 = digi.digivolutions.getChampionForms().getCompound(serializedName).getString("UltimateForm1");
                fz2 = digi.digivolutions.getChampionForms().getCompound(serializedName).getString("UltimateForm2");
                fz3 = digi.digivolutions.getChampionForms().getCompound(serializedName).getString("UltimateForm3");
                fz4 = digi.digivolutions.getChampionForms().getCompound(serializedName).getString("UltimateForm4");
                fztg = digi.digivolutions.getRookieForm();
            }
            if(FieldGuide.DigimonTypes.valueOf(fz0).getForm().equals(Form.FormTypes.ULTIMATE)){
                typ = "Ultimates";
                typ_id = 5;
                isKong = 1;
                fz1 = digi.digivolutions.getUltimateForms().getCompound(serializedName).getString("MegaForm1");
                fz2 = digi.digivolutions.getUltimateForms().getCompound(serializedName).getString("MegaForm2");
                fz3 = digi.digivolutions.getUltimateForms().getCompound(serializedName).getString("MegaForm3");
                fz4 = digi.digivolutions.getUltimateForms().getCompound(serializedName).getString("MegaForm4");
                fztg = digi.digivolutions.getRookieForm();
            }
            if(FieldGuide.DigimonTypes.valueOf(fz0).getForm().equals(Form.FormTypes.MEGA)){
                typ = "Mega";
                typ_id = 6;
                isKong = 2;
                fz1 = "";
                fz2 = "";
                fz3 = "";
                fz4 = "";
                fztg = digi.digivolutions.getRookieForm();
            }
            if(FieldGuide.DigimonTypes.valueOf(fz0).getForm().equals(Form.FormTypes.ROOKIE)){
                typ = "Rookie";
                typ_id = 3;
                isKong = 1;
                fz1 = digi.getEvolutions().getCompound(serializedName).getString("ChampionForm1");
                fz2 = digi.getEvolutions().getCompound(serializedName).getString("ChampionForm2");
                fz3 = digi.getEvolutions().getCompound(serializedName).getString("ChampionForm3");
                fz4 = digi.getEvolutions().getCompound(serializedName).getString("ChampionForm4");
                fztg = digi.digivolutions.getInTrainingForm();
            }
            if(FieldGuide.DigimonTypes.valueOf(fz0).getForm().equals(Form.FormTypes.ARMOR)){
                typ = "Armor";
                typ_id = -1;
                isKong = 2;
                fz1 = "";
                fz2 = "";
                fz3 = "";
                fz4 = "";
                fztg = digi.digivolutions.getRookieForm();
            }
            if(FieldGuide.DigimonTypes.valueOf(fz0).getForm().equals(Form.FormTypes.EGG)){
                typ = "Egg";
                typ_id = 0;
                isKong = 0;
                fz1 = digi.getEvolutions().getString("BabyForm");
                fz2 = "";
                fz3 = "";
                fz4 = "";
                fztg = digi.getEvolutions().getString("InTrainingForm");
            }
            if(FieldGuide.DigimonTypes.valueOf(fz0).getForm().equals(Form.FormTypes.BABY)){
                typ = "Baby";
                typ_id = 1;
                isKong = 0;
                fz1 = digi.getEvolutions().getString("InTrainingForm");
                fz2 = "";
                fz3 = "";
                fz4 = "";
                fztg = digi.getEvolutions().getString("EggForm");
            }
            if(FieldGuide.DigimonTypes.valueOf(fz0).getForm().equals(Form.FormTypes.INTRAINING)){
                typ = "Intra";
                typ_id = 2;
                isKong = 0;
                fz1 = digi.digivolutions.getRookieForm();
                fz2 = "";
                fz3 = "";
                fz4 = "";
                fztg = digi.getEvolutions().getString("BabyForm");
            }
            if(FieldGuide.DigimonTypes.valueOf(fz0).getForm().equals(Form.FormTypes.HYBRID)){
                typ = "Hybrid";
                typ_id = -2;
                isKong = 2;
                fz1 = "egg";
                fz2 = "egg";
                fz3 = "egg";
                fz4 = "egg";
                fztg = digi.getEvolutions().getString("EggForm");
            }
            fenzhi1 = new DTrIconButton(new ResourceLocation(Digimobs.MODID, "textures/sprites/" + (fz1.equalsIgnoreCase("") ? "egg" : fz1.toLowerCase()) + ".png"), this.width / 2, 35, 35, 35, new TranslationTextComponent("gui.button.e1"), new TranslationTextComponent("entity.digimobs." + fz1.toLowerCase()).getString(), (button) -> {
                fz0 = fz1;
                if(!Objects.equals(fz0, "egg"))
                    OpenFullDataGui(digimon, (byte) 2);
            });
            this.addButton(fenzhi1);
            fenzhi2 = new DTrIconButton(new ResourceLocation(Digimobs.MODID, "textures/sprites/" + (fz2.equalsIgnoreCase("") ? "egg" : fz2.toLowerCase()) + ".png"), this.width / 2, 80, 35, 35, new TranslationTextComponent("gui.button.e2"), new TranslationTextComponent("entity.digimobs." + fz2.toLowerCase()).getString(), (button) -> {
                fz0 = fz2;
                if(!Objects.equals(fz0, "egg"))
                    OpenFullDataGui(digimon, (byte) 2);
            });
            this.addButton(fenzhi2);
            fenzhi3 = new DTrIconButton(new ResourceLocation(Digimobs.MODID, "textures/sprites/" + (fz3.equalsIgnoreCase("") ? "egg" : fz3.toLowerCase()) + ".png"), this.width / 2, 125, 35, 35, new TranslationTextComponent("gui.button.e3"), new TranslationTextComponent("entity.digimobs." + fz3.toLowerCase()).getString(), (button) -> {
                fz0 = fz3;
                if(!Objects.equals(fz0, "egg"))
                    OpenFullDataGui(digimon, (byte) 2);
            });
            this.addButton(fenzhi3);
            fenzhi4 = new DTrIconButton(new ResourceLocation(Digimobs.MODID, "textures/sprites/" + (fz4.equalsIgnoreCase("") ? "egg" : fz4.toLowerCase()) + ".png"), this.width / 2, 170, 35, 35, new TranslationTextComponent("gui.button.e4"), new TranslationTextComponent("entity.digimobs." + fz4.toLowerCase()).getString(), (button) -> {
                fz0 = fz4;
                if(!Objects.equals(fz0, "egg"))
                    OpenFullDataGui(digimon, (byte) 2);
            });
            this.addButton(fenzhi4);
            fenzhi_ima = new DTrIconButton(new ResourceLocation(Digimobs.MODID, "textures/sprites/" + fz0.toLowerCase() + ".png"), this.width / 2 - 110, 35, 35, 35, new TranslationTextComponent("gui.button.ei"), new TranslationTextComponent("entity.digimobs." + fz0.toLowerCase()).getString(), (button) -> {

            });
            this.addButton(fenzhi_ima);
            fenLine = new DTrIconButton(new ResourceLocation(Digi_tsuuruzu.MOD_ID, "textures/gui/fen_line.png"), this.width / 2 - 75, 55, 60, 135, new TranslationTextComponent("gui.button.ei"), new TranslationTextComponent(" ").getString(), (button) -> {

            });
            this.addButton(fenLine);
            this.evo_back = new Button(this.width / 2 - 115, 180, 50, 20, new TranslationTextComponent("gui.button.evoback"), (button) -> {
                fz0 = fztg;
                OpenFullDataGui(digimon, (byte) 2);
            });
            this.addButton(evo_back);
            byte finalIsKong = isKong;
            byte finalTyp_id = typ_id;
            this.addEvo1 = new Button(this.width / 2 + 45, 45, 50, 20, new TranslationTextComponent(isKong == 2 ? "gui.button.kong" : "gui.button.evoadd"), (button) -> {
                editLine(finalIsKong, finalTyp_id, (byte) 1, this.textFieldWidget.getValue(), serializedName);
                OpenFullDataGui(digimon, (byte) 2);
            });
            this.addButton(addEvo1);
            this.addEvo2 = new Button(this.width / 2 + 45, 90, 50, 20, new TranslationTextComponent(isKong == 1 ? "gui.button.evoadd" : "gui.button.kong"), (button) -> {
                editLine(finalIsKong, finalTyp_id, (byte) 2, this.textFieldWidget.getValue(), serializedName);
                OpenFullDataGui(digimon, (byte) 2);
            });
            this.addButton(addEvo2);
            this.addEvo3 = new Button(this.width / 2 + 45, 135, 50, 20, new TranslationTextComponent(isKong == 1 ? "gui.button.evoadd" : "gui.button.kong"), (button) -> {
                editLine(finalIsKong, finalTyp_id, (byte) 3, this.textFieldWidget.getValue(), serializedName);
                OpenFullDataGui(digimon, (byte) 2);
            });
            this.addButton(addEvo3);
            this.addEvo4 = new Button(this.width / 2 + 45, 180, 50, 20, new TranslationTextComponent(isKong == 1 ? "gui.button.evoadd" : "gui.button.kong"), (button) -> {
                editLine(finalIsKong, finalTyp_id, (byte) 4, this.textFieldWidget.getValue(), serializedName);
                OpenFullDataGui(digimon, (byte) 2);
            });
            this.addButton(addEvo4);
        }
    }

    public static void editLine(byte isKong, byte id, byte num, String to, String now){
        if(Minecraft.getInstance().player.hasPermissions(2)) {
            if (isKong == 2) {
                return;
            } else if (isKong == 0 && num > 1) {
                return;
            } else {
                DigimonEntity digimonEntity = (DigimonEntity) digimon;
                switch (id) {
                    case 0:
                        digimonEntity.digivolutions.setBabyForm(to);
                    case 1:
                        digimonEntity.digivolutions.setInTrainingForm(to);
                    case 2:
                        digimonEntity.digivolutions.setRookieForm(to);
                    case 3:
                        digimonEntity.digivolutions.getChampionForms().put(to, new CompoundNBT());
                        digimonEntity.getEvolutions().getCompound(now).putString("ChampionForm" + num, to);
                    case 4:
                        digimonEntity.digivolutions.getUltimateForms().put(to, new CompoundNBT());
                        digimonEntity.digivolutions.getChampionForms().getCompound(now).putString("UltimateForm" + num, to);
                    case 5:
                        digimonEntity.digivolutions.getMegaForms().put(to, new CompoundNBT());
                        digimonEntity.digivolutions.getUltimateForms().getCompound(now).putString("MegaForm" + num, to);
                }
                NetworkRegHandler.CHANNEL.sendToServer(new SendPack(digimon.getUUID(),to+","+now,num, (int) id, (short) 1));
            }
        }else {
            Minecraft.getInstance().player.sendMessage(new StringTextComponent(new TranslationTextComponent("msg.dtr.noPress").getString()), Minecraft.getInstance().player.getUUID());
        }
    }

    public static String levelStats(int level){
        switch (level){
            case 0:
                return "S";
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
            case 6:
                return "F";
            case 7:
                return "G";
            default:
                return "??";
        }
    }

    public static String colorVPET(short co){
        switch (co){
            case 0:
                return "black";
            case 1:
                return "red";
            case 2:
                return "green";
            case 3:
                return "brown";
            case 4:
                return "blue";
            case 5:
                return "purple";
            case 6:
                return "cyan";
            case 7:
                return "silver";
            case 8:
                return "gray";
            case 9:
                return "pink";
            case 10:
                return "lime";
            case 11:
                return "yellow";
            case 12:
                return "lightblue";
            case 13:
                return "magenta";
            case 14:
                return "orange";
            case 15:
                return "white";
            case 30:
                return "pokeball";
            default:
                return "chushi";
        }
    }

}
