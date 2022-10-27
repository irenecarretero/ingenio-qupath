//Adapted from https://febs.onlinelibrary.wiley.com/doi/full/10.1002/1878-0261.12764

import static qupath.lib.gui.scripting.QPEx.*
import qupath.lib.objects.PathObjects
import qupath.lib.objects.classes.PathClassFactory
import qupath.lib.objects.classes.PathClassTools
import qupath.lib.objects.PathDetectionObject
import static qupath.lib.classifiers.PathClassifierTools.*


//Specify positive PD-L1 thresholds
pdl1_thres = 0.02


Tumor = getPathClass("Tumor")
pdl1_Pos = getPathClass("Positive") 
measurement1 = "Cytoplasm: DAB OD mean" 


//classify in tumor
selectObjects {p -> p.getPathClass() == getPathClass("Tumor")}
for (detection in getSelectedObjects()) {
    m1 = measurement(detection, measurement1) 

    if ( m1 > pdl1_thres )
        detection.setPathClass(pdl1_Pos)   

  else 
  detection.setPathClass(Tumor) 
            
}
fireHierarchyUpdate()
