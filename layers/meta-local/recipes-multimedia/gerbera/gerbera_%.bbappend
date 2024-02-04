FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
 
PACKAGECONFIG:append = " avcodec wavpack exiv2"

inherit useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "-r gerbera"
USERADD_PARAM:${PN} = "-r -g gerbera -d /var/lib/gerbera \
    -s /sbin/nologin -c \"Gerbera uPnP Server\" gerbera \
"

SRC_URI:append = " file://config.xml"

#
# todo change rights for /usr/share/gerbera
#

do_install:append() {
    install -m 0644 -o gerbera -g gerbera -d ${D}/etc/gerbera
    # login dir
    install -m 0644 -o gerbera -g gerbera -d ${D}/var/lib/gerbera
    install -m 0644 ${WORKDIR}/config.xml ${D}/etc/gerbera
    # chown gerbera:gerbera ${D}/etc/gerbera/config.xml
    chown gerbera:gerbera ${D}/usr/share/gerbera
}
