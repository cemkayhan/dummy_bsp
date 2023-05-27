#this file is the bootscript recipe.
#
  
SUMMARY = "Simple bootscript application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
  
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
  
SRC_URI = "file://bootscript \
        file://bootscript.service \
        file://econ_init_0 \
        file://econ_init_1 \
        file://econ_init_2 \
"
  
S = "${WORKDIR}"
  
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
  
inherit update-rc.d systemd
  
RDEPENDS:${PN} = "tcl"
INITSCRIPT_NAME = "bootscript"
INITSCRIPT_PARAMS = "start 99 S ."
  
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "bootscript.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
  
do_install() {
        if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
                install -d ${D}${sysconfdir}/init.d/
                install -m 0755 ${WORKDIR}/bootscript ${D}${sysconfdir}/init.d/
        fi
  
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/bootscript ${D}${bindir}/
        install -m 0755 ${WORKDIR}/econ_init_0 ${D}${bindir}/
        install -m 0755 ${WORKDIR}/econ_init_1 ${D}${bindir}/
        install -m 0755 ${WORKDIR}/econ_init_2 ${D}${bindir}/
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/bootscript.service ${D}${systemd_system_unitdir}
}
  
FILES:${PN} += "${@bb.utils.contains('DISTRO_FEATURES','sysvinit','${sysconfdir}/*', '', d)}"
