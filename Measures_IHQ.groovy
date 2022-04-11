
import qupath.lib.gui.tools.MeasurementExporter
import qupath.lib.objects.PathDetectionObject

// Get the list of all images in the current project
def project = getProject()
def imagesToExport = project.getImageList()

// Separate each measurement value in the output file with a tab ("\t")
def separator = "\t"

// Choose the columns that will be included in the export
// Note: if 'columnsToInclude' is empty, all columns will be included
def columnsToInclude = new String[]{"Image", 
                                     "Class", 
                                     "Parent",
                                     "Nucleus: Area",
                                     "Nucleus: Hematoxylin OD mean",
                                     "Nucleus: DAB OD mean",
                                     "Cytoplasm: DAB OD mean",
                                     "Cell: DAB OD mean"
                                     }

// Choose the type of objects that the export will process
// Other possibilities include:
//    1. PathAnnotationObject
//    2. PathDetectionObject
//    3. PathRootObject
//    4. PathCellObject.class
// Note: import statements should then be modified accordingly
def exportType = PathDetectionObject.class


// Set output path
def path = buildFilePath(PROJECT_BASE_DIR, 'measurementsIHQ.tsv')
def outputFile = new File(path)

// Create the measurementExporter and start the export
def exporter  = new MeasurementExporter()
                  .imageList(imagesToExport)            // Images from which measurements will be exported
                  .separator(separator)                 // Character that separates values
                  .includeOnlyColumns(columnsToInclude) // Columns are case-sensitive
                  .exportType(exportType)               // Type of objects to export
                  .exportMeasurements(outputFile)        // Start the export process

print "¡Hecho!"
