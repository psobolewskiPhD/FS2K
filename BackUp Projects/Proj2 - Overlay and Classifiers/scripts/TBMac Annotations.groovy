def macs = getDetectionObjects() //find all detection objects
def tbmacs = macs.findAll{it.getPathClass()==getPathClass('TBMacs')} //filter for the tingible body class
def newAnnots = tbmacs.collect{ //loop through each object individually, collecting the results into newAnnots
    //"it" refers to each cell as it goes through the loop
    PathObjects.createAnnotationObject(it.getROI(),it.getPathClass(),it.getMeasurementList()) // create an object with the same region of interest, classification, and measurements
} 

addObjects(newAnnots) //add the new annotations to the image, otherwise they are just saved in the variable and not real
removeObjects(macs,true) //