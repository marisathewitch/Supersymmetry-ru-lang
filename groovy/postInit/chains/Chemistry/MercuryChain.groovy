import static globals.Globals.*

ROASTER = recipemap('roaster')
FLOTATION = recipemap('froth_flotation')
MIXER = recipemap('mixer')
CLARIFIER = recipemap('clarifier')

MIXER.recipeBuilder()
    .inputs(metaitem('dustImpureCinnabar') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_cinnabar_slurry') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

FLOTATION.recipeBuilder()
    .fluidInputs(fluid('impure_cinnabar_slurry'))
    .notConsumable(metaitem('dustPotassiumButylXanthate'))
    .notConsumable(metaitem('dustLeadNitrate') * 5)
    .fluidOutputs(fluid('pegmatite_tailing_slurry') * 1000)
    .fluidOutputs(fluid('cinnabar_slurry') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

CLARIFIER.recipeBUilder()
    .fluidInputs(fluid('cinnabar_slurry') * 1000)
    .outputs(metaitem('dustCinnabar') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(Globals.voltAmps[1])
    .duration(20)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(metaitem('dustCinnabar'))
    .fluidInputs(fluid('oxygen') * 2000)
    .fluidOutputs(fluid('mercury') * 1000)
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()