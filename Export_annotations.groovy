//Adapted from: https://forum.image.sc/t/how-do-i-send-my-annotated-qupath-files-to-another-qupath-user-the-easiest-way/42979

def imageName = getProjectEntry().getImageName()

def annotations = getAnnotationObjects()
boolean prettyPrint = true
def gson = GsonTools.getInstance(prettyPrint)

//Revisar que hay anotaciones
if (!annotations) {
    print 'No hay anotaciones que exportar!'
    return
}

def path = buildFilePath(PROJECT_BASE_DIR, imageName)

def file = new File(path)
file.write(gson.toJson(annotations))

print "Hecho!"