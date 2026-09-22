PACKAGECONFIG:remove = "printing-and-pdf"

# QtWebEngineView launches this renderer helper at runtime. The upstream
# recipe installs it but does not otherwise assign it to a package.
FILES:${PN} += "${libexecdir}/QtWebEngineProcess"
