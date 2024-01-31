 
PACKAGECONFIG:append = " avcodec wavpack exiv2"

inherit useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "-r gerbera"
USERADD_PARAM:${PN} = "-r -g gerbera -d /var/lib/gerbera \
    -s /sbin/nologin -c \"Gerbera uPnP Server\" gerbera \
"
