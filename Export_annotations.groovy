//Adapted from: https://forum.image.sc/t/how-do-i-send-my-annotated-qupath-files-to-another-qupath-user-the-easiest-way/42979

def imageName = getProjectEntry().getImageName()

def annotations = getAnnotationObjects() 
def detections = getDetectionObjects()

boolean prettyPrint = true
def gson = GsonTools.getInstance(prettyPrint)

//Revisar que hay anotaciones
if (!annotations) {
    print 'No hay anotaciones que exportar!'
    return
}

def path = buildFilePath(PROJECT_BASE_DIR, imageName)

def file1 = new File(path + '_annotations.json')
file1.write(gson.toJson(annotations))
def file2 = new File(path + '_detections.json')
file2.write(gson.toJson(detections))

print "Hecho!"
